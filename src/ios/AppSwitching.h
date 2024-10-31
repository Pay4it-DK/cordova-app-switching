#import <Cordova/CDV.h>

@interface AppSwitching : CDVPlugin

- (void)canLaunch:(CDVInvokedUrlCommand*)command;
- (void)openApp:(CDVInvokedUrlCommand*)command;

@end