SUMMARY = "Multi-dimensional dynamically distorted staggered multi-bandpass LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BAngr"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BAngr.git;branch=master;protocol=https"
SRCREV = "ec25efa0a7a090a8f31dccafa02fe6ffc437aeba"
S = "${WORKDIR}/git"
PV = "1.4.0"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
