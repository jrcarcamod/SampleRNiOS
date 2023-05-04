//
//  PushNotificationDR.h
//  DigitalReefSDK
//
//  Created by Ailton Feller on 14/09/21.
//

#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>

NS_ASSUME_NONNULL_BEGIN

@interface PushNotificationDR : NSObject <UNUserNotificationCenterDelegate>


+(void) initializePushWithLaunchOptions:(NSDictionary *)launchOptions actionBlock:(void(^)(NSDictionary *result))completionHandler;
+(void) setCompletionHandler:(void(^)(NSDictionary *result))completionHandler;
+(void) registerToken:(NSData *)deviceToken;
+(void) sendPushAnalyticsWithPushUUID:(NSString *)push_uuid action:(NSString *)action;
+(void) openAppWithURI:(NSString *)uri storeLink:(NSString *)iTunesLink storeID:(NSNumber *) storeID;
+(void) includeMediaAttachmentWithRequest:(UNNotificationRequest *)request mutableContent:(UNMutableNotificationContent *)bestAttemptContent contentHandler:(void (^)(UNNotificationContent * _Nonnull))contentHandler;
+(void) callHandleActionWithDict:(NSDictionary *) dictionary;

BOOL checkIfInstanceOverridesSelector(Class instance, SEL selector);
Class getClassWithProtocolInHierarchy(Class searchClass, Protocol* protocolToFind);
NSArray* ClassGetSubclasses(Class parentClass);
void injectToProperClass(SEL newSel, SEL makeLikeSel, NSArray* delegateSubclasses, Class myClass, Class delegateClass);
BOOL injectSelector(Class newClass, SEL newSel, Class addToClass, SEL makeLikeSel);
+(void) setAsDelegate;
+(void) requestPushPermission;
+(void) flowsenseHandlePushWithUserInfo:(NSDictionary*) userInfo fetchCompletionHandler:(nullable void (^)(UIBackgroundFetchResult))completionHandler;
+(void) flowsenseHandleResponseWithNotificationResponse:(UNNotificationResponse *)response;
+(void) isRegisteredForPush;
+(void) setNotificationResponseHandler:(void(^)(UNNotificationResponse *response))completionHandler;
+(void) callHandleResponse:(UNNotificationResponse *)response;
+(void) setNotificationDataWithRequest:(UNNotificationRequest *)request adInfo:(NSDictionary *)adsInfo mutableContent:(UNMutableNotificationContent *)bestAttemptContent contentHandler:(void (^)(UNNotificationContent * _Nonnull))contentHandler;
+(BOOL) showAdAndStoreInDB:(NSDictionary *) userInfo;
+ (void) removeAllDeliveredPushNotifications;
+ (void) removeAllDeliveredPushNotifications:(int)optInValue;
+ (void) removeTPDeliveredPushNotifications;
+ (void) removeAllDeliveredAPNSNotifications;
+(NSDictionary *) getAd:(NSDictionary *) userInfo;
+ (void)addCategory:(NSMutableArray *)actionArray adId:(NSString *)adId toNotificationContent:(UNMutableNotificationContent*)content;
+ (void) removePendingPushNotificationsAdId:(NSString *)adId campaignId:(NSString *)campaignId;
+ (void) removePushNotificationsOnlyFromNotificationCenterAdId:(NSString *)adId campaignId:(NSString *)campaignId;
+ (void) removeOldOrgDeliveredNotifications:(NSString *) oldOrganization;

- (void)didRegisterForAPNSRemoteNotification:(UIApplication*)app deviceToken:(NSData*)inDeviceToken;
- (void)didReceiveAPNSRemoteNotification:(UIApplication*)application userInfo:(NSDictionary*)userInfo fetchCompletionHandler:(void (^)(UIBackgroundFetchResult))completionHandler;
@end

NS_ASSUME_NONNULL_END
