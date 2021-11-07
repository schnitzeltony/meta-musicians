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

SRC_URI = "git://github.com/sjaehn/BSEQuencer.git;branch=master;protocol=https"
SRCREV = "7ad4bf9b02c54ed98b8d293c52d1eca62fec626d"
S = "${WORKDIR}/git"
PV = "1.8.10"

EXTRA_OEMAKE = "STRIP=echo STRIPFLAG=-e"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES:${PN} += "${libdir}/lv2"
