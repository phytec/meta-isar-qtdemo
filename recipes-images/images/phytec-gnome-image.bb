require recipes-images/images/phytec-headless-image.bb

SUMMARY =  "Mini example of a desktop image"
LICENSE = "MIT"

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL += "\
    packagegroup-base \
    packagegroup-gstreamer \
    swap \
"

IMAGE_PREINSTALL += "\
    gnome \
    vim \
"

