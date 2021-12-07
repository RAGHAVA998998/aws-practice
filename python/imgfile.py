 
import os.path
import matplotlib.pyplot as plt
import matplotlib.cbook as cbook
# from skimage.io import imread
# from skimage import data_dir
# img = imread(os.path.join(data_dir, 'checker_bilevel.png'))
with cbook.get_sample_data('C:/Users/APPLE/Documents/vs_code/python/checker_bilevel.png') as imgfile:
    img=plt.imread(imgfile)
with cbook.get_sample_data('C:/Users/APPLE/Pictures/20129-2-monkey-d-luffy-transparent-background-thumb.png') as imgfileluffy:
    img2=plt.imread(imgfileluffy)


print(type(img),img.shape)
print(img2.shape,img2.ndim)
imgre=img2.reshape(100,400,4)
plt.imshow(imgre,cmap = 'Greys')