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
SRCREV = "4ffa9f99e0e89b16d654230a2bc65dd165d1c634"
S = "${WORKDIR}/git"
PV = "1.10.0"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
