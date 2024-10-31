

var AppSwitching = {
    isinstalled: function (appSwitchId, successCallback, errorCallback) {
        alert("Yes");
    },
    openApp: function (url, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "AppSwitching", "openApp", [url]);
    },
};

module.exports = AppSwitching;