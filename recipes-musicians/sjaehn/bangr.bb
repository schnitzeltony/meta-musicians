SUMMARY = "Multi-dimensional dynamically distorted staggered multi-bandpass LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BAngr"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BAngr.git;branch=master;protocol=https"
SRCREV = "e5893db858c39ef8ba1b1798dc7040e4f72de2a7"
S = "${WORKDIR}/git"
PV = "1.6.0"

EXTRA_OEMAKE += " \
    STRIP=echo \
"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
