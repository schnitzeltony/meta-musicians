SUMMARY = "Audio glitch effect sequencer LV2 plugin"
HOMEPAGE = "https://github.com/sjaehn/BOops"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
    libsndfile1 \
"

SRC_URI = "git://github.com/sjaehn/BOops.git"
SRCREV = "b4545121b522f758d89d29a3affbd2e308bdd075"
S = "${WORKDIR}/git"
PE = "1"
PV = "1.8.0"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
