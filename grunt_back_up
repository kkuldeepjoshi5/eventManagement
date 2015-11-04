module.exports = function( grunt ){

   grunt.initConfig({
	   imagemin:{
		   static:{
				options:{
					optimizationLevel:5
				},
				files:[{
					  expand: true,
				      cwd: 'src/main/webapp/images',
				      src: ['**/*.{png,jpg,gif}'],
				      dest: 'src/main/webapp/imageMin/'
				}]
			}
		},
	   jshint:{
		 all:['*.js']
	   },
      uglify: {
         dist:{
        	 src:'src/main/webapp/app/app-module.js',
        	 dest:'src/main/webapp/app/app-module.min.js'
         }
      },
      cssmin:{
    	  compress:{
    		  options:{

    		  },
    		  files:{
    			  'src/main/webapp/css/mobile.min.css':['src/main/webapp/css/mobile.css'],
    			  'src/main/webapp/css/web.min.css':['src/main/webapp/css/web.css']
    		  }
    	  }
      },
      requirejs: {
          compile: {
              options: {
                  baseUrl: "src/main/webapp/app",
                  paths   :
                  {
                      // Configure alias to full paths; relative to `baseURL`
                  },
                  out: 'src/main/webapp/angular-app.min.js',
                  name: 'app-module'
              },
              preserveLicenseComments : false,
              optimize: "uglify"
          }
      }
   });

   grunt.loadNpmTasks('grunt-contrib-imagemin');
   grunt.loadNpmTasks('grunt-contrib-uglify');
   grunt.loadNpmTasks('grunt-contrib-jshint');
   grunt.loadNpmTasks('grunt-contrib-cssmin');
   grunt.loadNpmTasks('grunt-contrib-requirejs');
   grunt.registerTask('default',['imagemin','jshint','uglify','cssmin','requirejs']);
};
