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
  'htmlFileListController', 
  function($scope, $filter, $http, $sce, url) {
    $scope.selectedFileName = null;
    $scope.selectedFileUrl = null;
    $scope.htmlText = null;

    var editor = ace.edit('code-editor');
    editor.setTheme("ace/theme/chrome");
    editor.getSession().setMode("ace/mode/html");
    editor.setOptions({
      readOnly: true,
  	  fontSize: '11pt'
   	});
    $scope.editor = editor;
    $scope.showFind = function () {
      $scope.editor.execCommand("find");
    };
    
    var browser = $('#html-browser');
    browser
    .on('load', function () {
      var element = $(this);
      var contents = element.contents();
      $scope.$apply(function () {
        $scope.htmlText = '<!DOCTYPE HTML>\n<!-- ' + $scope.selectedFileName + ' -->\n' + contents[0].body.innerHTML;
        $scope.editor.setValue($scope.htmlText);
        $scope.editor.gotoLine(0, 0);
        $scope.editor.renderer.scrollCursorIntoView({row: 0, column: 0}, 0);
      });
    })
    $scope.browser = browser;
        	
    $scope.selectFile = function (file) {
      $scope.selectedFileName = file.name;
      $scope.selectedFileUrl = $sce.trustAsResourceUrl(url + '/data/' + file.name);
    };
    
    $scope.query = function () {
      var input = $('#query-input').find('textarea').val();
      var result = $scope.browser.contents().find(input);
      var output = result ? JSON.stringify(result.html()) : '(nothing found)';
      $('#query-output').find('textarea').val(output);
    };

    var options = {
      method: 'GET',
      url: url + '/list'
    };
    $http(options).then(
      function (success) {
	    $scope.list = $filter('orderBy')(success.data, 'name');
	    $scope.error = null;
      }, 
      function (error) {
	    $scope.list = null;  
        $scope.error = error.data; 
      }
    );
  }
);