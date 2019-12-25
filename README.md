# MultiLanguage  


Apps include resources that can be specific to a particular culture. 
For example, an app can include culture-specific strings that are translated to the language of the current locale.
It's a good practice to keep culture-specific resources separated from the rest of your app.
Android resolves language- and culture-specific resources based on the system locale setting.  
You can provide support for different locales by using the resources directory in your Android project.  


For example, the following are some different resource files for different languages:  

English strings (default locale), `/values/strings.xml`:
```xml
<resources>
    <string name="hello_world">Hello World!</string>
</resources>
```
Spanish strings (es locale), `/values-es/strings.xml`:
```xml
<resources>
    <string name="hello_world">¡Hola Mundo!</string>
</resources>
```

- Use the resources in your app  

You can reference the resources in your source code and other XML files using each resource's name attribute.  
In your source code, you can refer to a resource using the syntax `R.<resource type>.<resource name>.` 
There are a variety of methods that accept a resource this way.   
 
For example:  
 
```java
// Get a string resource from your app's Resources
String hello = getResources().getString(R.string.hello_world);
// Or supply a string resource to a method that requires a string
TextView textView = new TextView(this);
textView.setText(R.string.hello_world);
```


- Support layout mirroring
People who use `RTL` scripts prefer an `RTL` user interface, which includes right-aligned menus, right-aligned text, and forward arrows pointing to the left.  


<p align="center">
  <img src="https://developer.android.com/images/training/basics/ltr-display.png"  height="440" width="270"/>
 <img src="https://developer.android.com/images/training/basics/rtl-display.png"  height="440" width="270"/>
</p>

Modify your app module's `build.gradle` file and app manifest file as follows:  

*build.gradle (Module: app)*  
```gradle
android {
    ...
    defaultConfig {
        targetSdkVersion 17 // Or higher
        ...
    }
}
```
*AndroidManifest.xml*
```xml
<manifest ... >
    ...
    <application ...
        android:supportsRtl="true">
    </application>
</manifest>
```




