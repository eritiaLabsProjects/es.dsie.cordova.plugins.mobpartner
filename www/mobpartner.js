var MobPartner = {};

MobPartner.showBanner= function(poolId) {
    cordova.exec(function(successParams){}, function(errorParams){}, "MobPartnerPlugin", "showBanner", [poolId]);
  };

MobPartner.showInterstitial= function(poolId) {
    cordova.exec(function(successParams){}, function(errorParams){}, "MobPartnerPlugin", "showInterstitial", [poolId]);
  };



module.exports = MobPartner;
