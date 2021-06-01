DTB_FILES ?= ""

SRC_URI_append_mx6 += "file://ubinize.cfg.tmpl"

TEMPLATE_VARS_mx6 = "KERNEL_IMG DTB_IMG UBIFS_IMG UBI_VOLNAME"
TEMPLATE_FILES_mx6 = "ubinize.cfg.tmpl"

KERNEL_IMG_mx6 = "${PP_DEPLOY}/${KERNEL_IMAGE}"
# only one dtb file supported, pick the first
DTB_IMG_mx6 = "${PP_DEPLOY}/${@(d.getVar('DTB_FILES').split() or [''])[0]}"

UBIFS_IMG_mx6 = "${PP_DEPLOY}/${UBIFS_IMAGE_FILE}"

do_copy_boot_files_append() {
    if [ -f "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE}" ]; then
        ln -sf ${KERNEL_IMAGE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}
    fi
}

IMAGE_INSTALL += " \
    new-hostname \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd-machine-units", "",d)} \
"

IMAGE_PREINSTALL += " \
    iputils-ping \
"

# Isar removes resolv.conf symlink during build
# We need to renew it until fixing upstream
rootfs_setup_resolved() {
    sudo -E chroot ${ROOTFSDIR} sh -c 'systemctl preset systemd-resolved.service && \
        ln -sr /run/systemd/resolve/resolv.conf /etc/resolv.conf'
}
ROOTFS_POSTPROCESS_COMMAND += "rootfs_setup_resolved"

rootfs_enable_root_ssh () {
    sudo sed -i "s/^#*PermitRootLogin[-A-Za-z=/ ]*$/PermitRootLogin yes/g" ${IMAGE_ROOTFS}/etc/ssh/sshd_config
}
ROOTFS_POSTPROCESS_COMMAND += "rootfs_enable_root_ssh"
