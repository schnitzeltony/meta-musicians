SUMMARY = "Pattern-controlled MIDI amp & time stretch plugin"
DESCRIPTION = "Pattern-controlled MIDI amp & time stretch plugin to produce shuffle / swing effects"
HOMEPAGE = "https://github.com/sjaehn/BSchaffl"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BSchaffl.git;branch=master;protocol=https"
SRCREV = "b2ff199403f33b3d606dd361a795b30621f93232"
S = "${WORKDIR}/git"
PV = "1.4.10"

EXTRA_OEMAKE = "STRIP=echo STRIPFLAG=-e"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
