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
