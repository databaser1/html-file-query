var app = angular.module('app', []);

app.config(
  [
    '$controllerProvider', 
    function($controllerProvider) {
      $controllerProvider.allowGlobals();
    }
  ]
);

app.value('url', '');

app.controller(
  'planReaderController', 
  function($scope, $http, url) {
    
    $scope.getDate = function (){
      var dateStr = $('#date').text();
      if (!dateStr) {
        $scope.setDate();
        return new Date();        
      }
      var dateParts = dateStr.split('-');
      if (dateParts.length < 3 || isNaN(dateParts[0]) || isNaN(dateParts[1]) || isNaN(dateParts[2])) {
        $scope.setDate();
        return new Date();
      }
      
      var timeObj = new Date();
      var dateObj = new Date(
        dateParts[0], 
        dateParts[1] - 1, 
        dateParts[2], 
        timeObj.getHours(), 
        timeObj.getMinutes(),
        timeObj.getSeconds(),
        timeObj.getMilliseconds()
      );
      return dateObj;
    };
    $scope.setDate = function (dateObj) {
      if (!dateObj)
        dateObj = new Date();
      var dateParts = [];
      dateParts.push(dateObj.getFullYear());
      dateParts.push(dateObj.getMonth() + 1);
      dateParts.push(dateObj.getDate());
      var dateStr = dateParts[0] + '-' + (dateParts[1] < 10 ? '0' + dateParts[1] : dateParts[1]) + '-' + (dateParts[2] < 10 ? '0' + dateParts[2] : dateParts[2]);
      $('#date').text(dateStr);
      
      $scope.getPlan(dateObj);
    };
    
    $scope.dateSpin = function (days) {
      var dateObj = $scope.getDate();
      dateObj.setDate(dateObj.getDate() + days);
      $scope.setDate(dateObj);
    };
    
    $scope.getPlan = function (dateObj) {
      if (!dateObj)
        dateObj = new Date();
      
      var monthNum = dateObj.getMonth() + 1;
      var dateNum = dateObj.getDate();
      var options = {
          method: 'GET',
          url: url + '/plan' + '/' + monthNum + '/' + dateNum
      };
      $http(options).then(
        function (success) {
          $scope.plan = success.data;
          $scope.error = null;
          var html = $scope.plan ? $scope.plan : '（无阅读计划）';
          $('#plan-container').html(html);
          var anchors = $('#plan-container .content-anchor');
          var titles = $('#plan-container .content-title');
          var linkPanel = $('#link-panel');
          for (var i = 0; i < anchors.length; i++) {
            var anchor = $(anchors[i]);
            var title = $(titles[i]);
            var id = anchor.attr('id');
            var text = title.text();
            linkPanel.append('<a class="content-link" href="#' + id + '">' + text + '</a>');
          }
        }, 
        function (error) {
          $scope.plan = null;  
          $scope.error = error.data; 
        }
      );
    };
    
    $scope.setDate();
  }
);