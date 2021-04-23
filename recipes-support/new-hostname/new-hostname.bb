inherit dpkg-raw

DESCRIPTION = "Change hostname to machine name"
MAINTAINER = "isar-users <isar-users@googlegroups.com>"

do_install () {
	install -d -m 0775 ${D}/etc/
        echo "${MACHINE}" > ${D}/etc/hostname
}
