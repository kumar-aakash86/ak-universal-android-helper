# ak-universal-android-helper
A helper library to ease the most repetitive codes with simple reusable attributes.

AKUAH can help you with many repetitive tasks of daily life development.

I am using this library in my own projects from quit a time. Now I decided to share in for public use. 
I have not implemented all the features I used to have in my old library but will keep adding them and some new features. 

Currently this library contains following features.

[**Custom Detailed Log Messages**](https://github.com/kumar-aakash86/ak-universal-android-helper/wiki/Custom-Log-Messages)    
AKUAH provides a simple solution for this logging with more detailed solution than android default log. It provides a more simple & clean solution for the logging.
    
[**Device Stats Check**](https://github.com/kumar-aakash86/ak-universal-android-helper/wiki/Device-Stats-Check)    
AKUAH helps you to identity device specific info & device other status like Network availability, GPS Module availability, Gyroscope availability, Front Camera availability etc.

**It includes following options**

    Check Network availability
    Check GPS Module availability in device
    Check Gyroscope Module availability in device
    Check Front Camera availability in device
    
[**Alerts and Notifications**](https://github.com/kumar-aakash86/ak-universal-android-helper/wiki/Alerts-&-Notifications)    
Custom snackbars

[**Actions & Events**](https://github.com/kumar-aakash86/ak-universal-android-helper/wiki/Alerts-&-Notifications)    
Custom snackbars

[**Custom Fonts**](https://github.com/kumar-aakash86/ak-universal-android-helper/wiki/Custom-Fonts)
Custom fonts on textview, edittext & buttons

[**Date Formats**](https://github.com/kumar-aakash86/ak-universal-android-helper/wiki/Date-Formats)
Date formatting

**Usage**    
Add this in your application's build.gradle
    
    compile 'ak.andro.kumaraakash86:ak-universal-helper:0.14'


**Setup**    
Setup AKUniversalHelper with following code in application file.    

        AKUniversalConfiguration.Builder config = new AKUniversalConfiguration.Builder(mContext);
        AKUniversalHelper.getInstance().init(config.build());

You are ready to go.    
See [wiki](https://github.com/kumar-aakash86/ak-universal-android-helper/wiki) for syntax guide    


**Version: 0.14**
* Custom font helper updated

**Version: 0.13**
* Custom font helper added
* Date helper added

**Version: 0.12**    
* Shake Detection    
    
    
**Version: 0.11**    
* Library Setup from application file for advance future implementation
* Enable/Disable library logs from library setup