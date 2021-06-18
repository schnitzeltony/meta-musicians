SUMMARY = "Beat / envelope shaper LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BShapr"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BShapr.git"
SRCREV = "38f4f68fda1b1bb26f50040ea5f18a4f8970cf91"
S = "${WORKDIR}/git"
PV = "0.13"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
