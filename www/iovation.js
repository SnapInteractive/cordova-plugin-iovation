module.exports = {
  start: function(successCallback, errorCallback) {
    cordova.exec(
        successCallback,
        errorCallback,
        'Iovation',
        'start', []
    );
  },

  blackbox: function(successCallback, errorCallback) {
    cordova.exec(
        successCallback,
        errorCallback,
        'Iovation',
        'blackbox', []
    );
  }
};
