#import "Iovation.h"
#import <iovation/DevicePrint.h>

@implementation Iovation

- (void)start:(CDVInvokedUrlCommand *)command {
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    [DevicePrint start];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)blackbox:(CDVInvokedUrlCommand *)command {
    CDVPluginResult *pluginResult = nil;

    NSString *blackbox = [DevicePrint blackbox];
    if (blackbox) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:blackbox];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
