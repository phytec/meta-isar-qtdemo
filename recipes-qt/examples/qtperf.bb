SRC_URI = " \
    git://github.com/amikan/qtperf;protocol=https \
"
SRCREV = "f602a7e92c6cd28cbc937f532afd0a69e44db051"

S = "${WORKDIR}/git"

inherit dpkg

DEBIAN_BUILD_DEPENDS = "qt5-qmake, qtbase5-dev"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    cat << EOF > ${S}/debian/${PN}.install
qtperf /usr/bin/
EOF

    deb_debianize
}

