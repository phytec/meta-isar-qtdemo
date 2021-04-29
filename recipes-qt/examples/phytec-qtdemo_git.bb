# Copyright (C) 2015 PHYTEC Messtechnik GmbH
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is a demo software showing some Qt Features"
HOMEPAGE = "http://www.phytec.de"

SRC_URI = " \
    git://git.phytec.de/phyRDKDemo;protocol=https \
    file://phytec-qtdemo.service;subdir=git \
    file://PhyKitDemo.conf;subdir=git \
    file://postinst \
"
SRCREV = "5fd5a82ccee3347be2b9bc61f13ee604b9ae22fd"
PV = "1.6"

S = "${WORKDIR}/git"

inherit dpkg

DPKG_ARCH = "${DISTRO_ARCH}"

DEBIAN_BUILD_DEPENDS = "qt5-qmake, qtbase5-dev, qtdeclarative5-dev"

DEBIAN_DEPENDS += "\
    qml-module-qtquick2, \
    qml-module-qtquick-controls2, \
    qml-module-qtquick-layouts, \
    qml-module-qtquick-window2, \
    qml-module-qtqml-models2, \
    gstreamer1.0-libav, \
    gstreamer1.0-plugins-base, \
    gstreamer1.0-plugins-good, \
    qtvirtualkeyboard-plugin, \
"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cat << EOF > ${S}/debian/${PN}.install
phytec-qtdemo /usr/bin/
QtDemo /usr/bin/
phytec-qtdemo.service /lib/systemd/system/
PhyKitDemo.conf /home/root/.config/Phytec/

# democontent
images/page_phytec_*.png /usr/share/${PN}/images/

# videos
media/caminandes.webm /usr/share/${PN}/videos/
EOF

    deb_debianize

    ln -sfr ${S}/phytec-qtdemo ${S}/QtDemo
}

