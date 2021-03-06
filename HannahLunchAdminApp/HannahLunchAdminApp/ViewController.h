//
//  ViewController.h
//  SavingImagesTutorial
//
//  Created by Sidwyn Koh on 29/1/12.
//

#import <UIKit/UIKit.h>
#import <Parse/Parse.h>
#import <MBProgressHUD/MBProgressHUD.h>
#include <stdlib.h> // For math functions including arc4random (a number randomizer)

@interface ViewController : UIViewController <UINavigationControllerDelegate, UIImagePickerControllerDelegate, MBProgressHUDDelegate,UIActionSheetDelegate>
{
    
    MBProgressHUD *HUD;
    MBProgressHUD *refreshHUD;
}

@property (nonatomic, strong) IBOutlet UIButton *lunchButton;

@end
