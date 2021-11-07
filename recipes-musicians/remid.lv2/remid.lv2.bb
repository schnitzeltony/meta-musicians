SUMMARY = "LV2 port of SID 6581 chip used in the Commodore 64"
HOMEPAGE = "https://github.com/ssj71/reMID.lv2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

DEPENDS += " \
    glib-2.0 \
    alsa-lib\
    jack \
    lv2 \
"

inherit cmake pkgconfig

SRC_URI = "git://github.com/ssj71/reMID.lv2.git;branch=master;protocol=https"
SRCREV = "7427f1bb44e9bda677ff2098a79420c47927d1e9"
S = "${WORKDIR}/git"
PV = "0.3"

FILES:${PN} += "${libdir}/lv2"
