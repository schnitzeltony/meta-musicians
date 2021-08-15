SUMMARY = "A LV2 toy"
HOMEPAGE = "https://github.com/brummer10/Xmonk.lv2"
LICENSE = "BSD-0-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ed1102993e593e0f97408b1bd982836a"

inherit pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    virtual/libx11 \
    cairo \
    lv2 \
"

SRC_URI = " \
    gitsm://github.com/brummer10/Xmonk.lv2.git;protocol=https \
    file://0001-Adjust-to-oe-build.patch \
"
SRCREV = "099827f93abcf3bab4a1f23e8648f763c548db3d"
PV = "0.4+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    PREFIX=${prefix} \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LIBDIR=${libdir} install
}

FILES:${PN} += "${libdir}/lv2"
