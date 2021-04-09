inherit dpkg-raw

DESCRIPTION = "Userlandtools for gstreamer and cameras"

DEBIAN_DEPENDS = "\
    v4l-utils, \
    gstreamer1.0-x, \
    libgstreamer1.0-0, \
    gstreamer1.0-libav, \
    gstreamer1.0-plugins-base, \
    gstreamer1.0-plugins-good, \
    gstreamer1.0-plugins-bad, \
"

#TODO: implement packages
#DEBIAN_DEPENDS += " \
#    gst-plugin-i2c, \
#"
#
# Camera tools by PHYTEC
#DEBIAN_DEPENDS_append_mx6 = " \
#    phytec-camera-examples-imx6, \
#    bvtest, \
#    gstreamer1.0-plugin-vita1300-remapper, \
#"
#
#DEBIAN_DEPENDS_append_mx6ul = " \
#    phytec-gstreamer-examples-imx6ul, \
#    bvtest, \
#    phytec-v4l2-c-examples-imx6ul, \
#"
#
#DEBIAN_DEPENDS_append_mx8m = " \
#    phytec-gstreamer-examples-imx8m, \
#    bvtest, \
#    phytec-v4l2-c-examples-imx8m, \
#    imx-gst1.0-plugin-gplay, \
#    imx-gst1.0-plugin, \
#"
#
