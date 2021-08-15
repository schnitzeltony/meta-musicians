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
SRCREV = "eb705aacb57724efa13d6571cac6804a73810ab9"
S = "${WORKDIR}/git"
PE = "1"
PV = "1.6.0"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
