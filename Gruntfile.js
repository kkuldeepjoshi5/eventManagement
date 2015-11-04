module.exports = function( grunt ){

	grunt.initConfig({
		 
		   jshint:{
			 all:['*.js']
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
	      }
	   });

	  
	   grunt.loadNpmTasks('grunt-contrib-jshint');
	   grunt.loadNpmTasks('grunt-contrib-cssmin');
	   grunt.registerTask('default',['jshint','cssmin']);
};
