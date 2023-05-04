#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface DRInAppHelper : NSObject

@property (strong, nonatomic) NSString *msgID, *name, *type, *category, *backgroundURL, *backgroundColor, *htmlURL, *themeColor, *closeButtonPosition, *engagementAdType, *adId, *campaignId, *ctaActionType;
@property (nonatomic) long start_sending, stop_sending;
@property (nonatomic) int must_validate;
@property (strong, nonatomic) NSMutableDictionary *display_when, *in_app_content;

- (instancetype) initWithDictionary:(NSDictionary *) dict engagementAdType:(NSString *) engAdType adId:(NSString *) adId campaignId:(NSString *) campaignId ctaActionType:(NSString *) ctaAction ;

@end

NS_ASSUME_NONNULL_END
