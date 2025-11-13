DTB_FILES ?= ""

IMAGE_TEMPLATE_VARS_ubi += "UBI_VOLNAME"

KERNEL_IMG_mx6 = "${PP_DEPLOY}/${KERNEL_IMAGE}"
# only one dtb file supported, pick the first
DTB_IMG_mx6 = "${PP_DEPLOY}/${@(d.getVar('DTB_FILES').split() or [''])[0]}"

UBIFS_IMG_mx6 = "${PP_DEPLOY}/${IMAGE_FULLNAME}.ubifs"

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

rootfs_enable_root_ssh () {
    sudo sed -i "s/^#*PermitRootLogin[-A-Za-z=/ ]*$/PermitRootLogin yes/g" ${IMAGE_ROOTFS}/etc/ssh/sshd_config
}
ROOTFS_POSTPROCESS_COMMAND += "rootfs_enable_root_ssh"

rootfs_create_machine_id () {
    # Create machine-id
    sudo touch ${IMAGE_ROOTFS}/etc/machine-id
}
ROOTFS_POSTPROCESS_COMMAND += "${@bb.utils.contains("DISTRO_FEATURES", "systemd", "rootfs_create_machine_id", "", d)}"
