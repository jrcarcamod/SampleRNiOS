#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface DigitalReefPassthroughView : UIView

@property (nonatomic) BOOL isBanner;

- (void) setOnInAppRedender:(void(^)(void)) completionHandler;

@end

NS_ASSUME_NONNULL_END
