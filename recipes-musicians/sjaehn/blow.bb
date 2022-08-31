SUMMARY = "B.Low is the unique sample-based sound generator plugin"
HOMEPAGE = "https://github.com/sjaehn/BLow"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = " \
    gitsm://github.com/sjaehn/BLow.git;branch=master;protocol=https \
    file://0001-HPianoRoll.hpp-Add-include-to-fix-build-with-gcc12.patch \
    file://0002-Add-missing-include-to-fix-build-with-gcc-12.patch \
"
SRCREV = "77f7a6e36860df80469539a6ba7f5ba9b4479c92"
S = "${WORKDIR}/git"
PV = "1.2.0"

EXTRA_OEMAKE = "STRIP=echo STRIPFLAG=-e"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
