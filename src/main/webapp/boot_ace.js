/**
 *  Use aysnc script loader, configure the application module (for AngularJS)
 *  and initialize the application ( which configures routing )
 *
 *  @author 
 */

(function(window, head) {
    "use strict";
var root="";
    head.js(
    	// Pre-load these for splash-screen progress bar...
    	
    	{ jquery     : root+"/lib/jquery.js"},
    	{ bootstrap  : root+"/lib/bootstrap.js"},
    	{ angular    : root+"/lib/angular.js"},
    	{ underscore : root+"/lib/underscore.js"},
    	{ loadingBar : root+"/lib/loading-bar.js"},
    	{ angularIdle: root+"/lib/angular-idle.js"},
    	{ angularTranslate : root+"/lib/angular-translate.js"},
    	{ uiRouter   : root+"/lib/angular-ui.js"},
    	/*{  ngGrid    : root+"/lib/ng-grid.js"},*/
    	{  uiGrid    : root+"/angular-ui-grid/ui-grid.min.js"},
    	{ uiBootstrap: root+"/lib/bootstrap_tpls.js"},
    	{ uiSelect2  : root+"/lib/select2.min.js"},
    	{ ace : root+"/lib/ace.js"},
    	{ datepicker : root+"/lib/datepicker.js"},
    	{ textAngular : root+"/lib/text-angular.js"},
    	{ angularFileUpload : root+"/lib/angular-file-upload.js"},
    	{ ngDragDrop: root+"/lib/angular-dragdrop.min.js"}/*,
    	{angularApp:root+"/angular-app.min.js"}*/
       
 
    )
    .ready("ALL", function() {

        require.config ({
            appDir  : '',
            baseUrl : './app',
            priority: 'angular',
            paths   :
            {
                // Configure alias to full paths

            },
            shim    :
            {
                'underscore':
                {
                    exports : '_'
                }
            }
        });

        require(["app-module"], function(app) {
            // Application has bootstrapped and started...
        });

    });

}(window, head));