SUMMARY = "Polyphonic version of Xmonk.lv2"
HOMEPAGE = "https://github.com/brummer10/XPolyMonk.lv2"
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
    gitsm://github.com/brummer10/XPolyMonk.lv2.git;protocol=https \
    file://0001-Adjust-to-oe-build.patch \
    file://0002-Do-not-use-host-machine-s-ld-to-pack-resources.patch \
    file://0003-Fix-build-with-lv2-1.1.18.patch \
"
SRCREV = "512d109d20e0a46d87ece9fea9576052da60ab86"
PV = "0.6"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    PREFIX=${prefix} \
    STRIP=echo \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LIBDIR=${libdir} install
}

FILES_${PN} += "${libdir}/lv2"
