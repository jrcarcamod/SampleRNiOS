#import <UIKit/UIKit.h>
#import "InAppContent.h"
#import "DigitalReefPassthroughView.h"
#import "DRInAppModel.h"

NS_ASSUME_NONNULL_BEGIN

@interface DigitalReefShowInApp : UIView

@property (strong, nonatomic) IBOutlet UIView *alertView;
@property (strong, nonatomic) IBOutlet UIImageView *backgroundImageView;
@property (strong, nonatomic) IBOutlet UIStackView *fsInAppCenterContent;
@property (strong, nonatomic) IBOutlet DigitalReefPassthroughView *parentView;

@property int resourcesToDownload;
@property int countResources;
@property BOOL hasCarousel;
@property BOOL componentError;
@property (strong, nonatomic) NSData *backgroundImgData;

@property (weak, nonatomic) IBOutlet NSLayoutConstraint *centerY;
@property (weak, nonatomic) IBOutlet NSLayoutConstraint *trailing;
@property (weak, nonatomic) IBOutlet NSLayoutConstraint *leading;
@property (weak, nonatomic) IBOutlet NSLayoutConstraint *top;
@property (weak, nonatomic) IBOutlet NSLayoutConstraint *bottom;
@property (weak, nonatomic) IBOutlet NSLayoutConstraint *stackViewTop;
@property (weak, nonatomic) IBOutlet NSLayoutConstraint *stackViewBottom;

@property (weak, nonatomic) NSString *bannerType;

- (instancetype)initWithContent:(DRInAppModel*) content completionHandler:(void (^)(BOOL success)) handler;
+ (void) setUpComponentWithContent:(NSArray<NSDictionary*>* ) jsonElement andView:(UIStackView*) view andInstance:(DigitalReefShowInApp*) instance;
- (void)showAlert;
- (instancetype)init;
- (BOOL) isFullScreen;
- (void) dismissController;
- (void) closeEngagementAd;

@end

NS_ASSUME_NONNULL_END
