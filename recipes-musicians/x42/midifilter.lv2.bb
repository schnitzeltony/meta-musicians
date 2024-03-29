SUMMARY = "LV2 plugins to filter midi events"
HOMEPAGE = "http://x42.github.io/midifilter.lv2/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"

inherit pkgconfig

DEPENDS += "lv2"

SRC_URI = "git://github.com/x42/midifilter.lv2.git;branch=master;protocol=https"
SRCREV = "902b1026afa4b684bd7d9355dce6694fbcdc0dab"
PV = "0.6.7"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES:${PN} += "${libdir}/lv2"
