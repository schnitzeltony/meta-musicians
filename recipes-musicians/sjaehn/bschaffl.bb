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
SRCREV = "048122a3d45bdb7832c18c83d8b8ef0910247c8d"
S = "${WORKDIR}/git"
PV = "1.4.2"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
