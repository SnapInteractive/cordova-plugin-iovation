#import <Cordova/CDV.h>

@interface Iovation : CDVPlugin
- (void)start:(CDVInvokedUrlCommand *)command;
- (void)blackbox:(CDVInvokedUrlCommand *)command;
@end