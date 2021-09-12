SUMMARY = "An audio stream chopping LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BChoppr"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BChoppr.git"
SRCREV = "d576487c36b32ca36ce0539b4c73fd76e7737349"
S = "${WORKDIR}/git"
PV = "1.10.10"

EXTRA_OEMAKE = "STRIP=echo STRIPFLAG=-e"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
