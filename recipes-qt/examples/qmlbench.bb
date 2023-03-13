SRC_URI = " \
    git://github.com/CrimsonAS/qmlbench;protocol=https;branch=dev \
    file://0001-TMP-Disable-cmake.patch \
"
SRCREV = "6d298da7cda85b35aa22c68aac55fdb6513e68eb"

S = "${WORKDIR}/git"

inherit dpkg

DEBIAN_BUILD_DEPENDS = "cmake, qt5-qmake, qtbase5-dev, qtdeclarative5-dev"

DEBIAN_DEPENDS = "qml-module-qtgraphicaleffects"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cat << EOF > ${S}/debian/${PN}.install
src/qmlbench /usr/bin/
benchmarks /usr/lib/qmlbench/
shared /usr/lib/qmlbench/
tools /usr/lib/qmlbench/
EOF

    deb_debianize
}

