# waqar_shapable_images

# Custom Shapeable Images

In this library you can add any image into any kind of shapes as per your prefrences. It provides your to add images inside of the shape as well as outside of the shape.


## Author:

- [@MohammadWaqarYounas](https://www.github.com/MohammadWaqarYounas)


## Version
    Version: 1.0.0
## Deployment


#### Add it in your root build.gradle at the end of repositories:

```http
  	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

#### Add the dependency in your build.gradle

```http
  dependencies {
            implementation 'jp.wasabeef:glide-transformations:4.3.0'
	        implementation 'com.github.MohammadWaqarYounas:waqar_shapable_images:$Version'
	}
```
#### Parameters Required:

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Your Image Url/Drawable`      | `String/Int` | **Required**. your preferred image |
| `Drawable file`      | `Int` | **Required**. Drawable of shape to fetch |
| `Type`      | `String` | **Required**. "IN" / "OUT"|


#### How To Use:

```http
  Glide.with(context)
    .load(you_image_url/Drawable)
        .apply(RequestOptions
            .bitmapTransform(CustomMaskTransformation(your_shape_in_Drawable,"IN"))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)).into(imageView)
```


#### Process:
to put image inside the shape pass "IN" or if you wanbt to put images outside the shape pass "OUT" in CustomMaskTransformation() method.

