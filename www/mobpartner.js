var MobPartner = {};

MobPartner.showBanner= function(poolId) {
    cordova.exec(function(successParams){}, function(errorParams){}, "MobPartnerPlugin", "showBanner", [poolId]);
  };



module.exports = MobPartner;
