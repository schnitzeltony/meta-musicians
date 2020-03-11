SUMMARY = "qemu wrapper: add timout to qemu for infinite loop situations"
LICENSE = "MIT"
IC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit native

DEPENDS += "qemu-native"

DEFAULT_TIMEOUT ?= "30"

do_install() {
    install -d ${D}${bindir}
    for qemu in `find  ${STAGING_BINDIR_NATIVE} -name qemu-*`; do
        orig_name=`basename $qemu`
        wrapper_name="$orig_name-timeout"
        echo "timeout ${DEFAULT_TIMEOUT} $orig_name \$@" > ${D}${bindir}/$wrapper_name
       	chmod +x ${D}${bindir}/$wrapper_name
    done
}
