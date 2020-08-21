SUMMARY = "Multi channel MIDI step sequencer LV2 plugin with a variable matrix"
HOMEPAGE = "https://github.com/sjaehn/BSEQuencer"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BSEQuencer.git"
SRCREV = "27a8aef5002f3ec5477fba9f389121cfa89f0422"
S = "${WORKDIR}/git"
PV = "1.6.0"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
