#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface InAppContent : NSObject

@property (strong, nonatomic) NSString *title, *titleColor, *message, *messageColor, *backgroundColor, *imageURL, *iconURL, *htmlData, *htmlURL;
@property (strong, nonatomic) NSArray<NSDictionary *> *carousel;
@property (strong, nonatomic) NSArray<NSDictionary *> *buttonMetaData;

-(instancetype)initWithContent:(NSDictionary *) content;

@end

NS_ASSUME_NONNULL_END
