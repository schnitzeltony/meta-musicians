SUMMARY = "Pattern-controlled MIDI amp & time stretch plugin"
DESCRIPTION = "Pattern-controlled MIDI amp & time stretch plugin to produce shuffle / swing effects"
HOMEPAGE = "https://github.com/sjaehn/BSchaffl"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BSchaffl.git"
SRCREV = "83e3f540c0c8ac672e21db7e2077f3d09b3f0d56"
S = "${WORKDIR}/git"
PV = "1.2.2"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
