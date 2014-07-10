var RevMob = {};
  RevMob.TEST_DISABLED = 0;
RevMob.TEST_WITH_ADS = 1;
RevMob.TEST_WITHOUT_ADS = 2;

RevMob.startSession= function(appId) {
    cordova.exec(function(successParams){}, function(errorParams){}, "RevMobPlugin", "startSession", [appId]);
  };

RevMob.showFullscreen = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "RevMobPlugin", "showFullscreen", []);
	};

RevMob.openAdLink = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "RevMobPlugin", "openAdLink", []);
	};

RevMob.showPopup = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "RevMobPlugin", "showPopup", []);
	}

RevMob.showBanner = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "RevMobPlugin", "showBanner", []);
	};

RevMob.hideBanner = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "RevMobPlugin", "hideBanner", []);
	};

RevMob.setTestingMode = function(testingMode) {
		cordova.exec(null, null, "RevMobPlugin", "setTestingMode", [testingMode]);
	};

RevMob.printEnvironmentInformation = function() {
		cordova.exec(null, null, "RevMobPlugin", "printEnvironmentInformation", []);
	};

RevMob.setTimeoutInSeconds = function(seconds) {
		cordova.exec(null, null, "RevMobPlugin", "setTimeoutInSeconds", [seconds]);
	};
	


module.exports = RevMob;
