SUMMARY = "No loss LV2 sound effect plugin"
HOMEPAGE = "https://github.com/sjaehn/BSpacr"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = "git://github.com/sjaehn/BSpacr.git;branch=main"
SRCREV = "61dfb32bb669067a7c96fda9224b6263ef09ba6c"
S = "${WORKDIR}/git"
PV = "1.2.0"

do_install() {
    DESTDIR=${D} PREFIX=${prefix} oe_runmake install
}

FILES_${PN} += "${libdir}/lv2"
