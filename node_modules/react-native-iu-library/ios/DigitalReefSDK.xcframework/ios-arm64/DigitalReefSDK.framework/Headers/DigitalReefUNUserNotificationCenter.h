//
//  DigitalReefUNUserNotificationCenter.h
//  DigitalReefSDK
//
//  Created by Ailton Feller on 14/09/21.
//

#import <Foundation/Foundation.h>
#import <UserNotifications/UserNotifications.h>

NS_ASSUME_NONNULL_BEGIN

@interface DigitalReefUNUserNotificationCenter : NSObject

+(void) setupMethods;
+(void) takeActionForButton:(NSString *)actionIdentifier withInfo:(NSDictionary *) userInfo;

-(void)notifCenter:(UNUserNotificationCenter *)center willPresentNotification:(UNNotification *)notification withCompletionHandler:(void (^)(UNNotificationPresentationOptions options))completionHandler;
-(void)notifCenter:(UNUserNotificationCenter *)center didReceiveNotificationResponse:(UNNotificationResponse *)response withCompletionHandler:(void(^)())completionHandler;

@end

NS_ASSUME_NONNULL_END
