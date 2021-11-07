SUMMARY = "A chorus audio effect plugin based on DSP code by Togu Audio Line (TAL)"
HOMEPAGE = "https://github.com/SpotlightKid/ykchorus"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=02ad2afd072e9ce4a370bedb49e2b075"

inherit pkgconfig gtk-icon-cache lv2-turtle-helper pack_audio_plugins

DEPENDS += " \
    liblo \
    jack \
    virtual/libgl \
"

SRC_URI = "gitsm://github.com/SpotlightKid/ykchorus.git;branch=master;protocol=https"
SRCREV = "a6b1027e327f5118bbe48ae01e9fa58e14f93479"
PV = "0.2.2+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    PREFIX=${prefix} \
    NOOPT=true \
    SKIP_STRIPPING=true \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LIBDIR=${libdir} install
}
