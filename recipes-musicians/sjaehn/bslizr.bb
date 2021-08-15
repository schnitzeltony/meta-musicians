SUMMARY = "Sequenced audio slicing effect LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BSlizr"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BSlizr.git"
SRCREV = "8622533bbbd8eed3c9fb10e216a72591846d3807"
S = "${WORKDIR}/git"
PV = "1.2.16"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
